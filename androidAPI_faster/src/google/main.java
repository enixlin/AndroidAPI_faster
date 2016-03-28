package google;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class main {

	private JFrame frame;
	private JTextField textField;
	private String path;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("文档目录");
		label.setBounds(6, 34, 61, 16);
		frame.getContentPane().add(label);

		textField = new JTextField();
		textField.setBounds(64, 29, 297, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		// 单击文件选择
		JButton btnNewButton = new JButton("打开");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd = System.getProperty("user.dir");
				File file = new File(pwd);
				String title = "请选择Android ＡＰＩ目录";
				// 弹出文件选择框
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("请选择Android ＡＰＩ目录");
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				// jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				// jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int result = jfc.showOpenDialog(frame);
				if (JFileChooser.APPROVE_OPTION == result) {
					file = jfc.getSelectedFile();
					if (!file.isDirectory()) {
						JOptionPane.showMessageDialog(null, "你选择的目录不存在");
						return;
					}
					path = file.getAbsolutePath();
					
					textField.setText(path);
				} else {
					return;
				}
			}
		});
		btnNewButton.setBounds(355, 29, 75, 29);
		frame.getContentPane().add(btnNewButton);

		JLabel label_1 = new JLabel("原内容1");
		label_1.setBounds(6, 71, 61, 16);
		frame.getContentPane().add(label_1);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setColumns(30);
		textArea.setRows(10);
		textArea.setText(
				"<(link rel)[=]\\\"(stylesheet)\\\"\\n(href)[=]\\\"(http)://(fonts.googleapis.com/css)[?](family)[=](Roboto)[:](regular,medium,thin,italic,mediumitalic,bold)\\\"( title)[=]\\\"roboto\\\">");
		textArea.setBounds(64, 71, 360, 73);
		frame.getContentPane().add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("<script src=\\\"http://www.google.com/jsapi\\\" type=\\\"text/javascript\\\"></script>");
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(64, 166, 360, 73);
		frame.getContentPane().add(textArea_1);

		JLabel label_2 = new JLabel("原内容2");
		label_2.setBounds(6, 166, 61, 16);
		frame.getContentPane().add(label_2);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(64, 251, 360, 56);
		frame.getContentPane().add(textArea_2);

		JLabel label_3 = new JLabel("替换内容");
		label_3.setBounds(6, 251, 61, 16);
		frame.getContentPane().add(label_3);

		//执行替换
		JButton button = new JButton("替换");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormatDoc formatDoc=new FormatDoc();
				String path=textField.getText();
				String orin=textArea.getText();
				String orin1=textArea_1.getText();
				String dst=textArea_2.getText();
				formatDoc.setPath(path);
				formatDoc.setSrc(orin);
				formatDoc.setSrc1(orin1);
				formatDoc.setDst(dst);
				formatDoc.exec();
				label_3.setText("ok");
			}
		});
		button.setBounds(307, 466, 117, 29);
		frame.getContentPane().add(button);

		JLabel label_4 = new JLabel("处理结果：");
		label_4.setBounds(6, 356, 415, 16);
		frame.getContentPane().add(label_4);
	}
}
