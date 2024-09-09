module personal.project.cardmatchinggame {
    requires javafx.controls;
    requires javafx.fxml;


    opens personal.project.cardmatchinggame to javafx.fxml;
    exports personal.project.cardmatchinggame;
}