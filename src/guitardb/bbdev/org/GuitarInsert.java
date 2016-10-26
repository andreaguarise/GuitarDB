package guitardb.bbdev.org;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
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

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GuitarInsert() {
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
						"",
						modelField.getText());
				buff.save();
				Instrument.dbclose();
			}
		});
		toolBar.add(btnInsert);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {45, 100, 42, 130, 31, 0};
		gbl_panel.rowHeights = new int[]{26, 26, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblBrand = new JLabel("Brand:");
		GridBagConstraints gbc_lblBrand = new GridBagConstraints();
		gbc_lblBrand.anchor = GridBagConstraints.WEST;
		gbc_lblBrand.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrand.gridx = 0;
		gbc_lblBrand.gridy = 0;
		panel.add(lblBrand, gbc_lblBrand);
		
		brandField = new JTextField();
		GridBagConstraints gbc_brandField = new GridBagConstraints();
		gbc_brandField.fill = GridBagConstraints.HORIZONTAL;
		gbc_brandField.gridwidth = 3;
		gbc_brandField.insets = new Insets(0, 0, 5, 5);
		gbc_brandField.gridx = 1;
		gbc_brandField.gridy = 0;
		panel.add(brandField, gbc_brandField);
		
		JLabel lblModel = new JLabel("Model:");
		GridBagConstraints gbc_lblModel = new GridBagConstraints();
		gbc_lblModel.anchor = GridBagConstraints.WEST;
		gbc_lblModel.insets = new Insets(0, 0, 5, 5);
		gbc_lblModel.gridx = 0;
		gbc_lblModel.gridy = 1;
		panel.add(lblModel, gbc_lblModel);
		
		modelField = new JTextField();
		GridBagConstraints gbc_modelField = new GridBagConstraints();
		gbc_modelField.fill = GridBagConstraints.HORIZONTAL;
		gbc_modelField.gridwidth = 3;
		gbc_modelField.anchor = GridBagConstraints.NORTH;
		gbc_modelField.insets = new Insets(0, 0, 5, 5);
		gbc_modelField.gridx = 1;
		gbc_modelField.gridy = 1;
		panel.add(modelField, gbc_modelField);
		modelField.setColumns(10);
		
		JLabel lblYear = new JLabel("Year:");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.anchor = GridBagConstraints.WEST;
		gbc_lblYear.insets = new Insets(0, 0, 0, 5);
		gbc_lblYear.gridx = 0;
		gbc_lblYear.gridy = 2;
		panel.add(lblYear, gbc_lblYear);
		
		yearField = new JTextField();
		yearField.setColumns(10);
		GridBagConstraints gbc_yearField = new GridBagConstraints();
		gbc_yearField.fill = GridBagConstraints.HORIZONTAL;
		gbc_yearField.anchor = GridBagConstraints.NORTH;
		gbc_yearField.insets = new Insets(0, 0, 0, 5);
		gbc_yearField.gridx = 1;
		gbc_yearField.gridy = 2;
		panel.add(yearField, gbc_yearField);
		
	}
}
