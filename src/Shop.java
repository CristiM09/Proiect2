import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Pachet.Produs;

public class Shop {
    private JPanel rootPanel;
    private JComboBox cboption;
    private JButton btncomanda;
    private JTextField txttotal;
    private JTextField txtqty;
    private JList listaPui;
    private JComboBox item;
    private JButton btnsterge;
    private final ArrayList<String> lista = new ArrayList<>();
    public static DefaultListModel modelLista = new DefaultListModel();


    public Shop() {
        btncomanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"OK", "CANCEL"};
                int afisare = JOptionPane.showOptionDialog(null, "Sunteti siguri ca vreti sa comandati?", "Notificare",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, JOptionPane.CANCEL_OPTION);
                if (afisare == JOptionPane.YES_NO_OPTION) {

                    double qty;
                    String tip = (String) item.getSelectedItem();
                    qty = Double.parseDouble(txtqty.getText());
                    Produs prod_nou = new Produs(tip, qty);
                    if (cboption.getSelectedItem().equals("Gr")) {
                        prod_nou.setPret(10.0);  //Gr
                    }

                    //Afisare in lista.
                    for (int i = 0; i < lista.size(); i++) {
                        modelLista.addElement(lista.get(i));
                    }
                    modelLista.addElement("Produs: " + prod_nou.getTip() + " Cantitate: " + qty + " " + cboption.getSelectedItem() + "  -  Pret: " + prod_nou.getPret() + "RON");

                    txttotal.setText(Double.toString(prod_nou.getPret()));

                    listaPui.setModel(modelLista);


                }
            }
        });
        btnsterge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = { "OK", "CANCEL" };
               int sterge= JOptionPane.showOptionDialog(null, "Sunteti siguri ca vreti sa stergeti lista?", "Notificare",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null, options, options[0]);
               if (sterge == JOptionPane.YES_NO_OPTION) {
                   modelLista.clear();
               }
            }

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pachet.Shop");
        frame.setContentPane(new Shop().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
