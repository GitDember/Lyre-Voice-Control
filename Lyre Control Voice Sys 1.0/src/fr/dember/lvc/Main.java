package fr.dember.lvc;

/**
 * @author Tanguy J.
 */

public class Main extends javax.swing.JFrame {

    public static String[] main_args;
    
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp1 = new javax.swing.JSeparator();
        btn_connect_ = new javax.swing.JButton();
        btn_disconnect_ = new javax.swing.JButton();
        label_info = new javax.swing.JLabel();
        label_mic = new javax.swing.JLabel();
        label_load = new javax.swing.JLabel();
        label_detect = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lyre Voice Control");

        btn_connect_.setBackground(new java.awt.Color(0, 255, 51));
        btn_connect_.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_connect_.setText("Connection");
        btn_connect_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connect_ActionPerformed(evt);
            }
        });

        btn_disconnect_.setBackground(new java.awt.Color(255, 102, 102));
        btn_disconnect_.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_disconnect_.setText("Disconnection");
        btn_disconnect_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disconnect_ActionPerformed(evt);
            }
        });

        label_info.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_info.setText("IP: 192.168.1.23    Port: 3332");

        label_mic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_mic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/mic.png"))); // NOI18N

        label_load.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/loader-1.gif"))); // NOI18N

        label_detect.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label_detect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_detect.setText("Listening ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sp1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_connect_)
                                .addGap(18, 18, 18)
                                .addComponent(btn_disconnect_)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                                .addComponent(label_info, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(label_detect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_load, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_mic))
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_connect_)
                            .addComponent(btn_disconnect_)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_info)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sp1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_detect, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(label_mic)
                .addGap(38, 38, 38)
                .addComponent(label_load, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_connect_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connect_ActionPerformed
        Communication.onConnect(); 
    }//GEN-LAST:event_btn_connect_ActionPerformed

    private void btn_disconnect_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disconnect_ActionPerformed
        Communication.onDisconnect();
    }//GEN-LAST:event_btn_disconnect_ActionPerformed

    public static void main(String args[]) {
        main_args = args;
        new Main().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_connect_;
    private javax.swing.JButton btn_disconnect_;
    public static javax.swing.JLabel label_detect;
    private javax.swing.JLabel label_info;
    public static javax.swing.JLabel label_load;
    private javax.swing.JLabel label_mic;
    private javax.swing.JSeparator sp1;
    // End of variables declaration//GEN-END:variables
}
