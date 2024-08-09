package data;

import lombok.Data;

@Data
public class FoodDataDetails {

    String itemName;
    String quantity;
    String itemSubtype;

    String totalCal;
    String protein;

    String carb;
    String fat;

    String timeWhenTaken;
}
