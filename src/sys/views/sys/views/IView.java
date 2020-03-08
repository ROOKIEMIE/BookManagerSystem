package sys.views;

import java.awt.*;

public interface IView {
    Color TopicBackGroundColor = new Color(0, 255, 100);
    Color NormalBackGroundColor = new Color(255, 255, 255);
    Color ButtonBackGroundColor = new Color(255, 0, 255);

    Font TopicFont = new Font("微软雅黑", Font.BOLD, 36);
    Font NormalFont = new Font("宋体", Font.PLAIN, 24);
    Font ButtonFont = new Font("仿宋", Font.BOLD, 30);

    FlowLayout LFlowLayout = new FlowLayout();
    FlowLayout RFlowLayout = new FlowLayout();

    default void init() {
        initView();
        reinit();
        dealAction();
    };

    void initView();
    void reinit();
    void dealAction();
    void showView();
    void closeView();
}
