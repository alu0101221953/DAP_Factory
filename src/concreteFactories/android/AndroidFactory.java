package concreteFactories.android;

import abstractFactory.*;

public class AndroidFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Dialog createDialog() {
        return new AndroidDialog();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }

    @Override
    public NotificationCenter createNotificationCenter() {
        return new AndroidNotificationCenter();
    }
}
