package application;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Main extends Application {
	
	static ObservableList<String> names = FXCollections.observableArrayList();
	
	private ArrayList<Button> foods = new ArrayList<Button>();
	private ArrayList<Button> mealList = new ArrayList<Button>();
	private int totalCalories = 0;
	private int totalFat = 0;
	private int totalCarbs = 0;
	private int totalProtein = 0;
	private int totalFiber = 0;

	//Scene
	BorderPane bPane = new BorderPane();		
	
	public void importFile(String filename) {
		File inputFile;
		Scanner sc;
		
		try {
			inputFile = new File(filename);
			sc = new Scanner(inputFile);
			while(sc.hasNextLine()) {
				 String foodName = sc.nextLine();
				 //System.out.println(foodName);
				 Button food = new Button(foodName);
				 food.setMaxWidth(Double.MAX_VALUE);
				 foods.add(food);
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addNutrition() {
		totalCalories++;
		totalFat++;
		totalFiber++;
		totalCarbs++;
		totalProtein++;
	}

	public void remNutrition() {
		totalCalories--;
		totalFiber--;
		totalCarbs--;
		totalFat--;
		totalProtein--;
	}
	
	public void createLeft() {
		VBox foodList = new VBox();
		foodList.setPrefWidth(400);
		foodList.setAlignment(Pos.TOP_CENTER);
		foodList.setStyle("-fx-border-color: black");
		
		foodList.getChildren().clear();
		Text foodLbl = new Text("AVAILABLE FOODS");
		foodLbl.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		foodLbl.setUnderline(true);
		foodList.getChildren().add(foodLbl);
		
		ScrollPane sp = new ScrollPane();
		sp.setContent(foodList);
		
		//importFile();
		for(Button temp : foods) {
			 temp.setOnAction(new EventHandler<ActionEvent>() {
				 public void handle(ActionEvent e) {
					 Button temp1 = new Button(temp.getText());
					 temp1.setMaxWidth(Double.MAX_VALUE);
					 temp1.setOnAction(new EventHandler<ActionEvent>() {
						 public void handle(ActionEvent e) {
							 mealList.remove(temp1);
							 remNutrition();
							 
							 createCenter();
						 }
					 });
					 mealList.add(temp1);
					 addNutrition();
					 
					 createCenter();
				 }
			 });
			foodList.getChildren().add(temp);
		}
		
		
		bPane.setLeft(sp);;
	}
	
	public void createTop() {
		HBox utilBar = new HBox();
		utilBar.setSpacing(20);
		utilBar.setPadding(new Insets(20, 20, 20, 20));

		Button addFood = new Button();
		addFood.setText("ADD FOOD");
		addFood.setPrefSize(275, 20);
		addFood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				//StackPane addFoodPane = new StackPane();
				GridPane addFoodBox = new GridPane();
				//addFoodBox.setGridLinesVisible(true);
				
				Scene addFoodScene = new Scene(addFoodBox, 500, 300);
				Stage addFoodWindow = new Stage();
				addFoodWindow.setTitle("ADD FOOD");
				addFoodWindow.setScene(addFoodScene);
				
				//Name of Food
				Label nameLabel = new Label("Name:");
				addFoodBox.add(nameLabel, 0, 0);
				TextField name = new TextField("Enter Food Name");
				addFoodBox.add(name, 1, 0);
				
				//Nutrition Facts
				Label nutLabel = new Label("Nutrition:");
				nutLabel.setFont(Font.font(20));
				addFoodBox.add(nutLabel, 0, 1);
				
				Label calLabel = new Label("Calories:");
				addFoodBox.add(calLabel, 0, 2);
				TextField calText = new TextField("Enter Calories");
				addFoodBox.add(calText, 1, 2);
				
				Label fatLabel = new Label("Fat:");
				addFoodBox.add(fatLabel, 0, 3);
				TextField fatText = new TextField("Enter Fat");
				addFoodBox.add(fatText, 1, 3);
				
				Label carbLabel = new Label("Carbs:");
				addFoodBox.add(carbLabel, 0, 4);
				TextField carbText = new TextField("Enter Carbs");
				addFoodBox.add(carbText, 1, 4);
				
				Label proLabel = new Label("Protein:");
				addFoodBox.add(proLabel, 0, 5);
				TextField proText = new TextField("Enter Protein");
				addFoodBox.add(proText, 1, 5);
				
				Label fibLabel = new Label("Fiber:");
				addFoodBox.add(fibLabel, 0, 6);
				TextField fibText = new TextField("Enter Fiber");
				addFoodBox.add(fibText, 1, 6);
				
				Button submit = new Button("Submit");
				submit.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						Button newFood = new Button(name.getText());
						newFood.setMaxWidth(Double.MAX_VALUE);
						foods.add(newFood);
						createLeft();
						addFoodWindow.close();
						
					}
				});
				addFoodBox.add(submit, 0, 7);
				


				//addFoodPane.getChildren().add(addFoodBox);

				
				addFoodWindow.show();
			}
		});
		
		Button importFile = new Button();
		importFile.setText("IMPORT FILE");
		importFile.setPrefSize(275, 20);
		importFile.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				VBox importBox = new VBox();
				
				Scene importScene = new Scene(importBox, 500, 300);
				Stage importSceneWindow = new Stage();
				importSceneWindow.setTitle("IMPORT FILE");
				importSceneWindow.setScene(importScene);
				
				Label fileLabel = new Label("Enter Filename:");
				TextField fileText = new TextField();
				
				Button submit = new Button("Submit");
				submit.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						importFile(fileText.getText());
						createLeft();
						importSceneWindow.close();
					}
				});
				importBox.getChildren().addAll(fileLabel, fileText, submit);
				
				
				importSceneWindow.show();
			}
		});
		
	      Button exportFile = new Button();
	      exportFile.setText("EXPORT FILE");
	      exportFile.setPrefSize(275, 20);
	      exportFile.setOnAction(new EventHandler<ActionEvent>() {
	            public void handle(ActionEvent e) {
	                VBox exportBox = new VBox();
	                
	                Scene exportScene = new Scene(exportBox, 500, 300);
	                Stage exportWindow = new Stage();
	                exportWindow.setTitle("Export");
	                exportWindow.setScene(exportScene);
	                
	                Button exportFile = new Button("EXPORT FILE");
	                
	                exportFile.setOnAction(new EventHandler<ActionEvent>() {
	                    public void handle(ActionEvent e) {
	                        exportWindow.close();
	                    }
	                });
	                exportBox.getChildren().addAll(exportFile);
	                
	                exportWindow.show();
	            }
	        });
		
		Button filter = new Button();
		filter.setText("FILTER");
		filter.setPrefSize(275, 20);
		filter.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				VBox filterBox = new VBox();
				
				Scene filterScene = new Scene(filterBox, 500, 300);
				Stage filterWindow = new Stage();
				filterWindow.setTitle("Filter");
				filterWindow.setScene(filterScene);
				
				Button filter = new Button("Filter");

				filter.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						filterWindow.close();
					}
				});
				filterBox.getChildren().addAll(filter);

				filterWindow.show();
			}
		});
		
		Button analyze = new Button();
		analyze.setText("ANALYZE");
		analyze.setPrefSize(275, 20);
		analyze.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				VBox analyzeBox = new VBox();
				
				Scene analyzeScene = new Scene(analyzeBox, 500, 300);
				Stage analyzeWindow = new Stage();
				analyzeWindow.setTitle("Analyze");
				analyzeWindow.setScene(analyzeScene);
				
				Button analyze = new Button("Analyze");
				
				analyze.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						analyzeWindow.close();
					}
				});
				analyzeBox.getChildren().addAll(analyze);
				
				analyzeWindow.show();
			}
		});
		
		
		utilBar.getChildren().addAll(addFood, importFile, exportFile, filter, analyze);
		
		bPane.setTop(utilBar);
	}

	public void createRight() {
		GridPane mealInfo = new GridPane();
		mealInfo.setAlignment(Pos.TOP_CENTER);
		mealInfo.setPrefWidth(400);
		mealInfo.setStyle("-fx-border-color: black");
		
		//mealInfo.setGridLinesVisible(true);
		
		Text mealInfoLbl = new Text("MEAL TOTAL");
		mealInfoLbl.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		mealInfoLbl.setUnderline(true);
		mealInfo.add(mealInfoLbl, 0, 0);

		Label calories = new Label("Calories:");
		calories.setFont(Font.font(20));
		mealInfo.add(calories, 0, 10);
		Text caloriesInfo = new Text(totalCalories + " g");
		caloriesInfo.setFont(Font.font(21));
		mealInfo.add(caloriesInfo, 1, 10);
		
		Label protein = new Label("Protein:");
		protein.setFont(Font.font(20));
		mealInfo.add(protein, 0, 13);
		Text proteinInfo = new Text(totalProtein + " g");
		proteinInfo.setFont(Font.font(21));
		mealInfo.add(proteinInfo, 1, 13);
		
		Label fat = new Label("Fat:");
		fat.setFont(Font.font(20));
		mealInfo.add(fat, 0, 16);
		Text fatInfo = new Text(totalFat + " g");
		fatInfo.setFont(Font.font(21));
		mealInfo.add(fatInfo, 1, 16);
		
		Label carbs = new Label("Carbs:");
		carbs.setFont(Font.font(20));
		mealInfo.add(carbs, 0, 19);
		Text carbsInfo = new Text(totalCarbs + " g");
		carbsInfo.setFont(Font.font(21));
		mealInfo.add(carbsInfo, 1, 19);
		
		Label fiber = new Label("Fiber:");
		fiber.setFont(Font.font(20));
		mealInfo.add(fiber, 0, 21);
		Text fiberInfo = new Text(totalFiber + " g");
		fiberInfo.setFont(Font.font(21));
		mealInfo.add(fiberInfo, 1, 21);
		
		
		bPane.setRight(mealInfo);
	}
	
	public void createCenter() {
		VBox meal = new VBox();
		meal.setAlignment(Pos.TOP_CENTER);
		meal.setPrefWidth(400);
		meal.setStyle("-fx-border-color: black");
		
		Text mealLbl = new Text("CURRENT MEAL");
		mealLbl.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		mealLbl.setUnderline(true);
		meal.getChildren().add(mealLbl);
		
		for(Button temp : mealList) {
			meal.getChildren().add(temp);
		}
		
		ScrollPane sp = new ScrollPane();
        sp.setContent(meal);
        
		createRight();
		bPane.setCenter(sp);;
	}
	
	public void createGUI() {
		createTop();
		createLeft();
		createCenter();
		createRight();
	}
	
	@Override
	public void start(Stage primaryStage) {
		//Stage
		primaryStage.setTitle("GUI");
		
		createGUI();
		
		Scene scene = new Scene(bPane, 1200, 600, Color.DARKGRAY);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}