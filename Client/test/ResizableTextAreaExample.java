import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class ResizableTextAreaExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Resizable JTextArea Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSize();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSize();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSize();
            }

            private void updateSize() {
                SwingUtilities.invokeLater(() -> {
                    int preferredHeight = textArea.getPreferredSize().height;
                    int viewportHeight = scrollPane.getViewport().getSize().height;

                    if (preferredHeight > viewportHeight) {
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    } else {
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                    }
                });
            }
        });

        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}