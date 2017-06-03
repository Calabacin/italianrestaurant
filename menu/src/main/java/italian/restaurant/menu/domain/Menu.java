package italian.restaurant.menu.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    private List<Dish> starters = new ArrayList<>();

    private List<Dish> main = new ArrayList<>();

    private List<Dish> deserts = new ArrayList<>();

    public Menu addStarter(Dish dish) {
        starters.add(dish);
        return this;
    }

    public Menu addMain(Dish dish) {
        main.add(dish);
        return this;
    }

    public Menu addDesert(Dish dish) {
        deserts.add(dish);
        return this;
    }

}
