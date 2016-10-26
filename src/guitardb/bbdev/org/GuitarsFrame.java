package guitardb.bbdev.org;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import javax.swing.ListCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.Box;
import javax.swing.JTextField;

public class GuitarsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuitarsFrame frame = new GuitarsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuitarsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Guitar buff = (Guitar)list.getSelectedValue();
				System.out.println(buff.model);
			}
		});
		list.setCellRenderer(new GuitarListCellRenderer());
		scrollPane.setViewportView(list);
		
		JToolBar toolBar_2 = new JToolBar();
		scrollPane.setColumnHeaderView(toolBar_2);
		
		JButton btnUpdate = new JButton("Update");
		toolBar_2.add(btnUpdate);
		
		JButton btnInsertNew = new JButton("Insert New");
		toolBar_2.add(btnInsertNew);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		toolBar_2.add(horizontalGlue_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( ! list.isSelectionEmpty() ) {
					Guitar buff = (Guitar)list.getSelectedValue();
					String message = "Will delete: " + buff.nickName + ". Are you sure?";
					int response = JOptionPane.showConfirmDialog(null, message);
					System.out.println(response);
				}
			}
		});
		toolBar_2.add(btnDelete);
		btnInsertNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GuitarInsert frame = new GuitarInsert();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guitar buff = (Guitar)list.getSelectedValue();
				System.out.println("Call Update on " + buff.brand + buff.model);
			}
		});
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnLoad = new JButton("Refresh");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instrument.dbconnect();
				Guitars result = Guitar.all();
				list.setListData(result.list);
				Instrument.dbclose();
			}
		});
		toolBar.add(btnLoad);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		JButton btnConfig = new JButton("Config");
		toolBar.add(btnConfig);
		
		JToolBar toolBar_1 = new JToolBar();
		contentPane.add(toolBar_1, BorderLayout.SOUTH);
		
		JLabel lblSearch = new JLabel("Search:");
		toolBar_1.add(lblSearch);
		
		textField = new JTextField();
		toolBar_1.add(textField);
		textField.setColumns(10);
	}
	

}

class GuitarListCellRenderer extends JLabel implements ListCellRenderer {
	
	private Border border;
	GuitarListCellRenderer(){
		setOpaque(true);
		border = BorderFactory.createLineBorder(Color.RED, 1);
	}
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		Guitar guitar = (Guitar)value;
		setText( guitar.id + " - " + guitar.brand + " " + guitar.model + " " + guitar.year);
		 if (isSelected)

	      {
	         setBackground(list.getSelectionBackground());
	         setForeground(list.getSelectionForeground());
	      }
	      else
	      {
	         setBackground(list.getBackground());
	         setForeground(list.getForeground());
	      }

	      setFont(list.getFont());

	      setEnabled(list.isEnabled());

	      if (isSelected && cellHasFocus)
	         setBorder(border);
	      else
	         setBorder(null);
		return this;
		
	}
}
