package UserManageSystem;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//记录离校信息
public class OperationFrame extends JFrame implements ActionListener {
    /************************定义各控件******************************/
    private String welcomMsg="选择如下操作:";
    private JLabel lblWelcome=new JLabel(welcomMsg);
    private JButton btQuery=new JButton("显示详细信息");
    private JButton btModify=new JButton("记录离校信息");
    private JButton btExit=new JButton("退出");
    public OperationFrame() {
        /****************************界面初始化************************/
        super("当前查询: "+Conf.account);
        this.setLayout(new GridLayout(4,1));//设置布局管理器为GridLayout，将界面区域划分为4行1列，每个添加到该界面的组件占一个格子的空间
        this.add(lblWelcome);
        this.add(btQuery);
        this.add(btModify);
        this.add(btExit);
        this.setSize(300,250);
        GUIUtil.toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//frame.setDefaultCloseOperation()是设置用户在此窗体上发起 "close" 时默认执行的操作。
        //EXIT_ON_CLOSE（在 JFrame 中定义）：使用 System exit 方法退出应用程序。
        this.setResizable(false); //窗口大小不改变
        this.setVisible(true);//将指定对象设为可见
        /**********************增加监听*******************************/
        btQuery.addActionListener(this);
        btModify.addActionListener(this);
        btExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btQuery) {
            String message="您的详细资料为:\n";
            message+="姓名："+Conf.account+"\n";
            message+="学号："+Conf.password+"\n";
            message+="入校时间："+Conf.time+"\n";
            message+="离校时间："+Conf.leave+"\n";
            JOptionPane.showMessageDialog(this,message);
        }
        else if(e.getSource()==btModify) {
            new ModifyDialog(this);
        }
        else {
            JOptionPane.showMessageDialog(this,"谢谢光临");
            System.exit(0);
        }
    }
}
