package net.sf.memoranda.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 
public class SystemUsersFrame extends JPanel
                      implements ListSelectionListener {
    @SuppressWarnings("rawtypes")
	//Using JList for compatibility with List Model
    private JList list;
    private DefaultListModel listModel;
 
    private JButton addB;
    private JButton removeB;
    private JTextField userName;
    UsersList myUsers = UsersList.getInstance();
 
    public SystemUsersFrame() {
        super(new BorderLayout());
        
        listModel = new DefaultListModel();
        if(!myUsers.isEmpty()) {
        	String[] tmpList = myUsers.getNames();
        	for(int i = 0; i < tmpList.length; i++) {
        		listModel.addElement(tmpList[i]);
        	}
        }
 
        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
 
        //Create Add button and add a listener
        addB = new JButton("Add");
        AddButtonListener addListener = new AddButtonListener(addB);
        addB.setActionCommand("Add");
        addB.addActionListener(addListener);
        addB.setEnabled(false);
        
        //Create remove button and add a listener
        removeB = new JButton("Remove");
        removeB.setActionCommand("Remove");
        removeB.addActionListener(new RemoveButtonListener());
 
        //Create input field for a user and add a listener
        userName = new JTextField(10);
        userName.addActionListener(addListener);
        userName.getDocument().addDocumentListener(addListener);
        if(!listModel.isEmpty()) {
        	String name = listModel.getElementAt(
                    list.getSelectedIndex()).toString();
        } else {
        	String name = "";
        }
 
        //Create a panel that uses BoxLayout.
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,
                                           BoxLayout.LINE_AXIS));
        //Add the stuff to panel
        buttonPanel.add(removeB);
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPanel.add(Box.createHorizontalStrut(5));
        buttonPanel.add(userName);
        buttonPanel.add(addB);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
 
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
    }
 
    //Remove button listener that enables when theres a selection.
    class RemoveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = list.getSelectedIndex();
            myUsers.remove(listModel.get(index).toString());
            listModel.remove(index);
 
            int size = listModel.getSize();
            
            //If no selection, remove button is deactivated.
            if (size == 0) { 
                removeB.setEnabled(false);
 
            } else { 
                if (index == listModel.getSize()) {
                    index--;
                }
 
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }
 
    //This listener is shared by the text field and the add button.
    class AddButtonListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;
 
        public AddButtonListener(JButton button) {
            this.button = button;
        }
 
        //Required by ActionListener.
        @SuppressWarnings("unchecked")
        public void actionPerformed(ActionEvent e) {
            String name = userName.getText();
            //Doesn't add if names already in the list.
            if (name.equals("") || alreadyInList(name)) {
                Toolkit.getDefaultToolkit().beep();
                userName.requestFocusInWindow();
                userName.selectAll();
                return;
            }
 
            int index = list.getSelectedIndex();
            if (index == -1) { 
                index = 0;
            } else {  
                index++;
            }
            myUsers.add(userName.getText());
            listModel.insertElementAt(userName.getText(), index);
 
            //Reset the text field.
            userName.requestFocusInWindow();
            userName.setText("");
 
            //Select the new item and make it visible.
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }
        //Checks to see if item is already in the list
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }
 
        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }
 
        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }
 
        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }
 
        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }
 
        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }
 
    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (list.getSelectedIndex() == -1) {
            //No selection, disables remove button.
                removeB.setEnabled(false);
 
            } else {
            //Selection, enable the remove button.
                removeB.setEnabled(true);
            }
        }
    }
 
    //Displays the dialog.
    public static void display() {
        //Create and set up the window.
        JFrame frame = new JFrame("System Users");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new SystemUsersFrame();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
	    frame.setVisible(true);    
	    frame.setAlwaysOnTop(true);
    }
    
    // Returns string array of list
    public String[] getUsersArray() {
    	String[] stringArray = new String[listModel.getSize()];
    	for(int i = 0; i < listModel.getSize(); i++) {
    		stringArray[i] = listModel.get(i).toString();
    	}
    	return stringArray;
    }
}