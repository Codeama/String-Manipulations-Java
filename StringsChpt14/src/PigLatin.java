
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PigLatin extends JFrame{
	private JPanel jpanel;
	private JTextArea textArea1;
	private JButton button;
	private JTextArea textArea2;
	
	
	public PigLatin() {
		super("Pig Latin Translator");
		Box box = Box.createHorizontalBox();
		textArea1 = new JTextArea(10,15);
		box.add(new JScrollPane(textArea1));
		
		button = new JButton("Translate");
		box.add(button);
		
		textArea2 = new JTextArea(10,15);
		textArea2.setEditable(false);
		box.add(new JScrollPane(textArea2));
		
		
		TextButtonHandler handler = new TextButtonHandler();
		button.addActionListener(handler);
		
		add(box);
				
	}
	
	private class TextButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			
			StringBuilder string = new StringBuilder();
			String content = textArea1.getText();
			String edit = content.replaceAll("[\\W]", " ").toLowerCase();
			String[] token = edit.split(" ");
			
			//convert to Pig Latin			
			for(String word : token) {
				if(word.startsWith("a")||word.startsWith("e")||word.startsWith("i")
						||word.startsWith("o")||word.startsWith("u")||word.startsWith("hon")
						||word.startsWith("hour")||word.startsWith("heir"))
					string.append(word)
					.append("ay")
					.append(" ");
				else
					string.append(word.substring(1) + word.substring(0, 1))
					 .append("ay")
					 .append(" ");
			}
				
			textArea2.setText(string.toString());
		}
	}

}
