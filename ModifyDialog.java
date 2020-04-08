package UserManageSystem;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//修改离校时间
public class ModifyDialog extends  JDialog implements ActionListener {
    /*******************************定义各控件**************************/
    private JLabel lbMsg=new JLabel("姓名为：");
    private JLabel lbAccount=new JLabel(Conf.account);
    private JLabel lbPassword=new JLabel("修改学号");
    private JTextField pfPassword=new JTextField(Conf.password,20);
    private JLabel lbPassword2=new JLabel("修改确认学号");
    private JTextField pfPassword2=new JTextField(Conf.password,10);
    private JLabel lbTime=new JLabel("修改入校时间");
    private JTextField tfTime=new JTextField(Conf.time,10);
    private JLabel lbLeave=new JLabel("修改离校时间");
    private JTextField tfLeave=new JTextField(Conf.leave,10);
    private JButton btModify=new JButton("修改");
    private JButton btTime=new JButton("记录离校");
    private JButton btExit=new JButton("关闭");
    public ModifyDialog(JFrame frm) {
        /***********************界面初始化***************************/
        super(frm,true);
        this.setLayout(new GridLayout(7,2));
        this.add(lbMsg);
        this.add(lbAccount);
        this.add(lbPassword);
        this.add(pfPassword);
        this.add(lbPassword2);
        this.add(pfPassword2);
        this.add(lbTime);
        this.add(tfTime);
        this.add(lbLeave);
        this.add(tfLeave);
        this.add(btModify);
        this.add(btTime);
        this.add(btExit);
        this.setSize(300,200);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        /*******************增加监听*******************************/
        btModify.addActionListener(this);
        btExit.addActionListener(this);
        btTime.addActionListener(this);
        this.setResizable(false);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btModify) {
            String password1=pfPassword.getText();
            String password2=pfPassword2.getText();
            if(!password1.equals(password2)) {
                JOptionPane.showMessageDialog(this,"两个学号不相同");
                return;
            }
            String time=tfTime.getText();
            String leave=tfLeave.getText();
            //将新的值存入静态变量
            Conf.password=password1;
            Conf.time=time;
            Conf.leave=leave;
            FileOpe.updateCustomer(Conf.account,password1,time,leave);
            JOptionPane.showMessageDialog(this,"修改成功");
        }
        else if(e.getSource()==btTime) {
          String password1=pfPassword.getText();
             String password2=pfPassword2.getText();
             if(!password1.equals(password2)) {
                 JOptionPane.showMessageDialog(this,"两个学号不相同");
                 return;
             }
             SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
             String time=tfTime.getText();
             String leave=df.format(new Date());
             //将新的值存入静态变量
             Conf.password=password1;
             Conf.time=time;
             Conf.leave=leave;
             FileOpe.updateCustomer(Conf.account,password1,time,leave);
             JOptionPane.showMessageDialog(this,"修改成功");
        }
        else {
            this.dispose();
        }
    }
}
