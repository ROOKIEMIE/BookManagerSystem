package sys.views;

import javax.swing.*;
import java.awt.*;

public class MainView implements IView {
    private JFrame mainView;

    public MainView() {
    }

    @Override
    public void initView() {
        mainView = new JFrame("图书管理系统");
        mainView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainView.setMinimumSize(new Dimension(1000, 800));
        mainView.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainView.setResizable(true);
        mainView.setLocationRelativeTo(null);
    }

    @Override
    public void reinit() {

    }

    @Override
    public void dealAction() {

    }

    @Override
    public void showView() {

    }

    @Override
    public void closeView() {

    }
}
