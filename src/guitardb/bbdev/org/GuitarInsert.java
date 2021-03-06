package guitardb.bbdev.org;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
	private JList typeField;
	private JTextField serialField;
	private JTextField txtNickname;
	private JTextField stringGaugeField;
	private JTextField changeDateField;
	private JTextField priceField;
	
	private Guitar guitarIn;
	
	private Boolean editable;
	private Boolean insert = false;
	private Boolean update = false;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	public GuitarInsert(){
		System.out.println("GuitarInsert()");
	}
	
	public GuitarInsert build() {
		System.out.println("build()");
	
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		if ( insert ) {
			JButton btnInsert = new JButton("Insert");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Instrument.dbconnect();
					Guitar buff = new Guitar(brandField.getText(),
						Integer.parseInt(yearField.getText()),
						serialField.getText(),
						modelField.getText());
					buff.nickName = txtNickname.getText();
					buff.type = (String)typeField.getSelectedValue();
					buff.currentGauge = stringGaugeField.getText();
					buff.changeDate = changeDateField.getText();
					buff.pricePaid = Integer.parseInt(priceField.getText());
					buff.save();
					Instrument.dbclose();
				}
			});
			toolBar.add(btnInsert);
		}
		if ( update ) {
			JButton btnInsert = new JButton("Update");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Instrument.dbconnect();
					Guitar buff = new Guitar(brandField.getText(),
						Integer.parseInt(yearField.getText()),
						serialField.getText(),
						modelField.getText());
					buff.id = guitarIn.id;//use guitarIn for the key id
					buff.nickName = txtNickname.getText();
					buff.type = (String)typeField.getSelectedValue();
					buff.currentGauge = stringGaugeField.getText();
					buff.changeDate = changeDateField.getText();
					buff.pricePaid = Integer.parseInt(priceField.getText());
					buff.update();
					Instrument.dbclose();
				}
			});
			toolBar.add(btnInsert);
		}
		
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
		if (editable != null ) txtNickname.setEditable(editable);
		//System.out.println("old nick:" + guitarIn.nickName);
		if (guitarIn != null ) txtNickname.setText(guitarIn.nickName);
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
		if (editable != null ) brandField.setEditable(editable);
		if (guitarIn != null ) brandField.setText(guitarIn.brand);
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
		if (editable != null ) yearField.setEditable(editable);
		yearField.setColumns(10);
		if (guitarIn != null ) yearField.setText(Integer.toString(guitarIn.year));
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
		if (editable != null ) modelField.setEditable(editable);
		if (guitarIn != null ) modelField.setText(guitarIn.model);
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
		
		/*
		typeField = new JTextField();
		if (editable != null ) typeField.setEditable(editable);
		if (guitarIn != null ) typeField.setText(guitarIn.type);
		GridBagConstraints gbc_typeField = new GridBagConstraints();
		gbc_typeField.gridwidth = 2;
		gbc_typeField.insets = new Insets(0, 0, 5, 5);
		gbc_typeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeField.gridx = 1;
		gbc_typeField.gridy = 3;
		panel.add(typeField, gbc_typeField);
		typeField.setColumns(10);
		*/
		
		typeField = new JList(Guitar.types);
		if (editable != null ) typeField.setEnabled(editable);
		System.out.println(guitarIn.type);
		if (guitarIn != null ) typeField.setSelectedValue(guitarIn.type, false);
		GridBagConstraints gbc_typeField = new GridBagConstraints();
		gbc_typeField.gridwidth = 2;
		gbc_typeField.insets = new Insets(0, 0, 5, 5);
		gbc_typeField.fill = GridBagConstraints.HORIZONTAL;
		gbc_typeField.gridx = 1;
		gbc_typeField.gridy = 3;
		panel.add(typeField, gbc_typeField);
		
		JLabel lblPrice = new JLabel("Price:");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.anchor = GridBagConstraints.EAST;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 4;
		gbc_lblPrice.gridy = 3;
		panel.add(lblPrice, gbc_lblPrice);
		
		priceField = new JTextField();
		if (editable != null ) priceField.setEditable(editable);
		if (guitarIn != null ) priceField.setText(Integer.toString(guitarIn.pricePaid));
		GridBagConstraints gbc_priceField = new GridBagConstraints();
		gbc_priceField.insets = new Insets(0, 0, 5, 0);
		gbc_priceField.fill = GridBagConstraints.HORIZONTAL;
		gbc_priceField.gridx = 5;
		gbc_priceField.gridy = 3;
		panel.add(priceField, gbc_priceField);
		priceField.setColumns(10);
		
		JLabel lblSerial = new JLabel("Serial");
		GridBagConstraints gbc_lblSerial = new GridBagConstraints();
		gbc_lblSerial.anchor = GridBagConstraints.EAST;
		gbc_lblSerial.insets = new Insets(0, 0, 5, 5);
		gbc_lblSerial.gridx = 0;
		gbc_lblSerial.gridy = 4;
		panel.add(lblSerial, gbc_lblSerial);
		
		serialField = new JTextField();
		if (editable != null ) serialField.setEditable(editable);
		if (guitarIn != null ) serialField.setText(guitarIn.serial);
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
		if (editable != null ) stringGaugeField.setEditable(editable);
		if (guitarIn != null ) stringGaugeField.setText(guitarIn.currentGauge);
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
		if (editable != null ) changeDateField.setEditable(editable);
		if (guitarIn != null ) changeDateField.setText(guitarIn.changeDate);
		GridBagConstraints gbc_changeDateField = new GridBagConstraints();
		gbc_changeDateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_changeDateField.gridx = 5;
		gbc_changeDateField.gridy = 5;
		panel.add(changeDateField, gbc_changeDateField);
		changeDateField.setColumns(10);
		changeDateField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( !changeDateField.getText().isEmpty()) {
					Boolean valid = DateParser.isValidFormat("yyyy/MM/dd", changeDateField.getText());
					if (!valid ) {
						//System.out.println("date not valid:" + changeDateField.getText() );
						JOptionPane.showMessageDialog(contentPane, "Date must be in format yyyy/mm/dd");
						changeDateField.setText("");
					}
				}
			}
		});
		return this;
	}
	
	//Methods to implement the Builder Design Pattern 
	//use as:
	//Guitar buff = (Guitar)list.getSelectedValue();
	//GuitarInsert frame = new GuitarInsert().guitar(buff).editable(false);
	public GuitarInsert editable(Boolean editable)
	{
		System.out.println("editable()");
		this.editable=editable;
		return this;
	}
	
	public GuitarInsert insert()
	{
		this.insert = true;
		return this;
	}
	
	public GuitarInsert update()
	{
		this.update = true;
		return this;
	}
	
	public GuitarInsert guitar(Guitar in)
	{
		System.out.println("guitar()");
		this.guitarIn = in;		
		return this;
	}
}
