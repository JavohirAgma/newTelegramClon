package uz.pdp.ui.views;

import uz.pdp.ui.utils.ScanUtil;

public class GroupView {
    public static void profile() {
        System.out.println("Welcome to Group Page");
        while (true){
            Integer menu = menu();
            switch (menu){
                case 1->CreateGroup();
                case 2->SearchGroup();
                case 3->DeleteGroup();
                case 4-> {
                    return;
                }
            }
        }
    }

    private static void DeleteGroup() {

    }

    private static void SearchGroup() {

    }

    private static void CreateGroup() {

    }

    public static Integer menu(){
        System.out.println("""
                Groups Page:
                1.Create Group
                2.Search Group
                3.Go out of Group
                0.Exit
                """);
        return ScanUtil.intScan("Choose: ");
    }
}
