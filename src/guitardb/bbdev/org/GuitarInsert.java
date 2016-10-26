package guitardb.bbdev.org;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GuitarInsert extends JFrame {

	private JPanel contentPane;
	static Integer counter;
	private JTextField brandField;
	private JTextField modelField;
	private JTextField yearField;
	private JTextField typeField;
	private JTextField serialField;
	private JTextField txtNickname;
	private JTextField stringGaugeField;
	private JTextField changeDateField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GuitarInsert(Guitar in) {
		String nickBuff = "Insert nick here";
		String brandBuff = "brand here";
		if ( in != null )
		{
			System.out.println("Found:"+ in.brand);
			brandBuff = in.brand;
		}
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instrument.dbconnect();
				Guitar buff = new Guitar(brandField.getText(),
						Integer.parseInt(yearField.getText()),
						serialField.getText(),
						modelField.getText());
				buff.nickName = txtNickname.getText();
				buff.type = typeField.getText();
				buff.currentGauge = stringGaugeField.getText();
				buff.changeDate = changeDateField.getText();
				buff.save();
				Instrument.dbclose();
			}
		});
		toolBar.add(btnInsert);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {45, 50, 50, 42, 0, 130, 0};
		gbl_panel.rowHeights = new int[]{0, 26, 26, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNickname = new JLabel("Nickname:");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.anchor = GridBagConstraints.EAST;
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 0;
		gbc_lblNickname.gridy = 0;
		panel.add(lblNickname, gbc_lblNickname);
		
		txtNickname = new JTextField();
		txtNickname.setText(nickBuff);
		GridBagConstraints gbc_txtNickname = new GridBagConstraints();
		gbc_txtNickname.gridwidth = 5;
		gbc_txtNickname.insets = new Insets(0, 0, 5, 0);
		gbc_txtNickname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNickname.gridx = 1;
		gbc_txtNickname.gridy = 0;
		panel.add(txtNickname, gbc_txtNickname);
		txtNickname.setColumns(10);
		
		JLabel lblBrand = new JLabel("Brand:");
		GridBagConstraints gbc_lblBrand = new GridBagConstraints();
		gbc_lblBrand.anchor = GridBagConstraints.WEST;
		gbc_lblBrand.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrand.gridx = 0;
		gbc_lblBrand.gridy = 1;
		panel.add(lblBrand, gbc_lblBrand);
		
		brandField = new JTextField();
		brandField.setText(brandBuff);
		GridBagConstraints gbc_brandField = new GridBagConstraints();
		gbc_brandField.fill = GridBagConstraints.HORIZONTAL;
		gbc_brandField.gridwidth = 3;
		gbc_brandField.insets = new Insets(0, 0, 5, 5);
		gbc_brandField.gridx = 1;
		gbc_brandField.gridy = 1;
		panel.add(brandField, gbc_brandField);
		
		JLabel lblYear = new JLabel("Year:");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.anchor = GridBagConstraints.WEST;
		gbc_lblYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear.gridx = 4;
		gbc_lblYear.gridy = 1;
		panel.add(lblYear, gbc_lblYear);
		
		yearField = new JTextField();
		yearField.setColumns(10);
		GridBagConstraints gbc_yearField = new GridBagConstraints();
		gbc_yearField.insets = new Insets(0, 0, 5, 0);
		gbc_yearField.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearField.anchor = GridBagConstraints.NORTH;
		gbc_yearField.gridx = 5;
		gbc_yearField.gridy = 1;
		panel.add(yearField, gbc_yearField);
		
		JLabel lblModel = new JLabel("Model:");
		GridBagConstraints gbc_lblModel = new GridBagConstraints();
		gbc_lblModel.anchor = GridBagConstraints.WEST;
		gbc_lblModel.insets = new Insets(0, 0, 5, 5);
		gbc_lblModel.gridx = 0;
		gbc_lblModel.gridy = 2;
		panel.add(lblModel, gbc_lblModel);
		
		modelField = new JTextField();
		GridBagConstraints gbc_modelField = new GridBagConstraints();
		gbc_modelField.fill = GridBagConstraints.HORIZONTAL;
		gbc_modelField.gridwidth = 5;
		gbc_modelField.anchor = GridBagConstraints.NORTH;
		gbc_modelField.insets = new Insets(0, 0, 5, 0);
		gbc_modelField.gridx = 1;
		gbc_modelField.gridy = 2;
		panel.add(modelField, gbc_modelField);
		modelField.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 0;
		gbc_lblType.gridy = 3;
		panel.add(lblType, gbc_lblType);
		
		typeField = new JTextField();
		GridBagConstraints gbc_typeField = new GridBagConstraints();
		gbc_typeField.insets = new Insets(0, 0, 5, 5);
		gbc_typeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeField.gridx = 1;
		gbc_typeField.gridy = 3;
		panel.add(typeField, gbc_typeField);
		typeField.setColumns(10);
		
		JLabel lblSerial = new JLabel("Serial");
		GridBagConstraints gbc_lblSerial = new GridBagConstraints();
		gbc_lblSerial.anchor = GridBagConstraints.EAST;
		gbc_lblSerial.insets = new Insets(0, 0, 5, 5);
		gbc_lblSerial.gridx = 0;
		gbc_lblSerial.gridy = 4;
		panel.add(lblSerial, gbc_lblSerial);
		
		serialField = new JTextField();
		serialField.setText("Serial");
		GridBagConstraints gbc_serialField = new GridBagConstraints();
		gbc_serialField.insets = new Insets(0, 0, 5, 0);
		gbc_serialField.gridwidth = 5;
		gbc_serialField.fill = GridBagConstraints.HORIZONTAL;
		gbc_serialField.gridx = 1;
		gbc_serialField.gridy = 4;
		panel.add(serialField, gbc_serialField);
		serialField.setColumns(10);
		
		JLabel lblStringGauge = new JLabel("String Gauge");
		GridBagConstraints gbc_lblStringGauge = new GridBagConstraints();
		gbc_lblStringGauge.anchor = GridBagConstraints.EAST;
		gbc_lblStringGauge.insets = new Insets(0, 0, 0, 5);
		gbc_lblStringGauge.gridx = 0;
		gbc_lblStringGauge.gridy = 5;
		panel.add(lblStringGauge, gbc_lblStringGauge);
		
		stringGaugeField = new JTextField();
		GridBagConstraints gbc_stringGaugeField = new GridBagConstraints();
		gbc_stringGaugeField.gridwidth = 3;
		gbc_stringGaugeField.insets = new Insets(0, 0, 0, 5);
		gbc_stringGaugeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_stringGaugeField.gridx = 1;
		gbc_stringGaugeField.gridy = 5;
		panel.add(stringGaugeField, gbc_stringGaugeField);
		stringGaugeField.setColumns(10);
		
		JLabel lblChangedate = new JLabel("ChangeDate");
		GridBagConstraints gbc_lblChangedate = new GridBagConstraints();
		gbc_lblChangedate.anchor = GridBagConstraints.EAST;
		gbc_lblChangedate.insets = new Insets(0, 0, 0, 5);
		gbc_lblChangedate.gridx = 4;
		gbc_lblChangedate.gridy = 5;
		panel.add(lblChangedate, gbc_lblChangedate);
		
		changeDateField = new JTextField();
		GridBagConstraints gbc_changeDateField = new GridBagConstraints();
		gbc_changeDateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_changeDateField.gridx = 5;
		gbc_changeDateField.gridy = 5;
		panel.add(changeDateField, gbc_changeDateField);
		changeDateField.setColumns(10);
		
	}
}
