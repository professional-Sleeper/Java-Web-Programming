package com.scsa.jadv.test;
//package com.scsa.jadv.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EmpGUI {

	public IEmpMgr dao = EmpMgrImpl.getInstance();
	public ArrayList<Employee> emps = EmpMgrImpl.getInstance().getList();

	private Frame frame;
	private List list;
	private TextField txtEmpNo;
	private TextField txtName;
	private TextField txtDivision;
	private TextField txtPosition;
	private Label lblStatus;
	private Button btnAdd;
	private Button btnSearch;
	private Button btnUpdate;
	private Button btnDelete;
	private Button btnSave;
	private Button btnUpload;
	private Button btnClear;

	public EmpGUI() {
		frame = new Frame("EmpGUI");
		lblStatus = new Label();
		lblStatus.setBackground(Color.LIGHT_GRAY);
		lblStatus.setForeground(Color.BLUE);
		txtEmpNo = new TextField();
		txtName = new TextField();
		txtDivision = new TextField();
		txtPosition = new TextField();
		btnAdd = new Button("Add");
		btnUpdate = new Button("Update");
		btnSearch = new Button("Search");
		btnClear = new Button("Clear");
		btnDelete = new Button("Delete");
		btnSave = new Button("SaveTo");
		btnUpload = new Button("Upload");
		list = new List();

		Panel inputs = new Panel();
		Panel inputLables = new Panel();
		Panel inputFields = new Panel();
		Panel inputBtns = new Panel();
		inputLables.setLayout(new GridLayout(4, 1));
		Label lblEmpNo = new Label("EmpNo:");
		lblEmpNo.setAlignment(Label.CENTER);
		Label lblName = new Label("Name:");
		lblName.setAlignment(Label.CENTER);
		Label lblGrade = new Label("Position:");
		lblGrade.setAlignment(Label.CENTER);
		Label lblDiv = new Label("Division:");
		lblDiv.setAlignment(Label.CENTER);
		inputLables.add(lblEmpNo);
		inputLables.add(lblName);
		inputLables.add(lblGrade);
		inputLables.add(lblDiv);
		inputFields.setLayout(new GridLayout(4, 1));
		inputFields.add(txtEmpNo);
		inputFields.add(txtName);
		inputFields.add(txtPosition);
		inputFields.add(txtDivision);
		inputBtns.setLayout(new GridLayout(1, 4));
		inputBtns.add(btnAdd);
		inputBtns.add(btnUpdate);
		inputBtns.add(btnDelete);
		inputBtns.add(btnSearch);
		inputBtns.add(btnClear);

		inputs.setLayout(new BorderLayout());
		inputs.add(inputLables, BorderLayout.WEST);
		inputs.add(inputFields, BorderLayout.CENTER);
		inputs.add(inputBtns, BorderLayout.SOUTH);

		Panel center = new Panel();
		center.setLayout(new BorderLayout());
		center.add(list);
		center.add(lblStatus, BorderLayout.NORTH);

		Panel pnlBtns = new Panel();
		pnlBtns.setLayout(new GridLayout(1, 4));
		pnlBtns.add(btnSave);
		pnlBtns.add(btnUpload);

		frame.add(inputs, BorderLayout.NORTH);
		frame.add(center);
		frame.add(pnlBtns, BorderLayout.SOUTH);
		frame.setSize(300, 400);
		frame.setVisible(true);

		load();
	}

	/** �̺�Ʈ�� ����մϴ�. */
	public void addEvent() {
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});

		btnAdd.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (txtEmpNo.getText().isEmpty())
					lblStatus.setText("�����ȣ�� �Է��� �ּ���");
				else if (txtName.getText().isEmpty())
					lblStatus.setText("������� �Է��� �ּ���");
				else if (txtDivision.getText().isEmpty())
					lblStatus.setText("�μ��� �Է��� �ּ���");
				else if (txtPosition.getText().isEmpty())
					lblStatus.setText("������ �Է��� �ּ���");
				else {
					try {
						dao.add(new Employee(Integer.parseInt(txtEmpNo.getText()), txtName.getText(),
								txtDivision.getText(), txtPosition.getText()));
						showList();
						lblStatus.setText(txtEmpNo.getText() + "�� ����Ǿ����ϴ�.");
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						lblStatus.setText(txtEmpNo.getText() + "�� ���ڰ� �ƴմϴ�.");
					} catch (DuplicateException e1) {
						// TODO Auto-generated catch block
						lblStatus.setText(e1.getMessage());
					}
				}
			}

		});

		btnUpdate.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (txtEmpNo.getText().isEmpty())
					System.out.println("�����ȣ�� �Է��� �ּ���");
				else if (txtName.getText().isEmpty())
					System.out.println("������� �Է��� �ּ���");
				else if (txtPosition.getText().isEmpty())
					System.out.println("������ �Է��� �ּ���");
				else if (txtDivision.getText().isEmpty())
					System.out.println("�μ��� �Է��� �ּ���");
				else {
					try {
						dao.update(new Employee(Integer.parseInt(txtEmpNo.getText()), txtName.getText(),
								txtDivision.getText(), txtPosition.getText()));
						showList();
						lblStatus.setText(txtEmpNo.getText() + "�� �����Ǿ����ϴ�.");
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						lblStatus.setText(txtEmpNo.getText() + "�� ���ڰ� �ƴմϴ�.");
					} catch (RecordNotFoundException e1) {
						// TODO Auto-generated catch block
						lblStatus.setText(e1.getMessage());
					}
				}
			}

		});

		btnClear.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				clearField();
			}

		});

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str = list.getSelectedItem();
				StringTokenizer st = new StringTokenizer(str);

				txtEmpNo.setText(st.nextToken());
				txtName.setText(st.nextToken());
				txtPosition.setText(st.nextToken());
				txtDivision.setText(st.nextToken());
				lblStatus.setText(txtEmpNo.getText() + " �� ǥ���մϴ�.");
			}
		});

		btnDelete.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					dao.delete(Integer.parseInt(txtEmpNo.getText()));
					lblStatus.setText(txtEmpNo.getText() + " ������ �����Ͽ����ϴ�.");
					showList();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					lblStatus.setText(txtEmpNo.getText() + "�� ���ڰ� �ƴմϴ�.");
				} catch (RecordNotFoundException e1) {
					// TODO Auto-generated catch block
					lblStatus.setText(e1.getMessage());
				}

			}
		});

		btnSearch.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					if (txtEmpNo.getText().isEmpty()) {
						if (!txtName.getText().isEmpty()) {
							ArrayList<Employee> temp = dao.NameList(txtName.getText());
							list.removeAll();
							for (Employee employee : temp) {
								list.add(employee.getEmpNo() + " " + employee.getName() + " " + employee.getPosition()
										+ " " + employee.getDivision());
							}
							lblStatus.setText(txtName.getText() + "�� �˻��մϴ�.");
						}
						if (txtName.getText().isEmpty() && txtPosition.getText().isEmpty()
								&& txtDivision.getText().isEmpty()) {
							showList();
							lblStatus.setText("��ü ����Ʈ�� ����մϴ�.");
						}
					} else {
						Employee temp = dao.search(Integer.parseInt(txtEmpNo.getText()));
						txtEmpNo.setText(String.valueOf(temp.getEmpNo()));
						txtName.setText(temp.getName());
						txtPosition.setText(temp.getPosition());
						txtDivision.setText(temp.getDivision());
						lblStatus.setText(txtEmpNo.getText() + " �˻��� �����Ͽ����ϴ�.");
					}

				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					lblStatus.setText(txtEmpNo.getText() + "�� ���ڰ� �ƴմϴ�.");
				} catch (RecordNotFoundException e1) {
					// TODO Auto-generated catch block
					lblStatus.setText(e1.getMessage());
				}

			}
		});

		btnSave.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					dao.save("emp.dat");
					lblStatus.setText("���忡 �����Ͽ����ϴ�.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					lblStatus.setText("���忡 �����Ͽ����ϴ�.");
				}
			}
		});

		btnUpload.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					dao.upload();
					lblStatus.setText("���ۿ� �����Ͽ����ϴ�.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					lblStatus.setText("���ۿ� �����Ͽ����ϴ�.");
				}
			}
		});

	}

	/** AWT List ������Ʈ�� ���������� ǥ���մϴ�. */
	private void showList() {
		list.removeAll();
		for (Employee employee : emps) {
			list.add(employee.getEmpNo() + " " + employee.getName() + " " + employee.getPosition() + " "
					+ employee.getDivision());
		}
	}

	/** ���������� �Է��ϴ� TextField�� ������ ����ϴ�. */
	private void clearField() {
		txtEmpNo.getText();
		txtEmpNo.setText("");
		txtName.getText();
		txtName.setText("");
		txtPosition.getText();
		txtPosition.setText("");
		txtDivision.getText();
		txtDivision.setText("");
		lblStatus.setText("�Է�â�� �������ϴ�.");
	}

	private void load() {
		try {
			dao.load("emp.dat");
			showList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			lblStatus.setText("���� �ҷ����⸦ �����Ͽ����ϴ�.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			lblStatus.setText("���ϸ��� ã�� ���Ͽ����ϴ�.");
		}
	}

	public static void main(String[] args) {
		EmpGUI ui = new EmpGUI();
		ui.addEvent();
	}
}
