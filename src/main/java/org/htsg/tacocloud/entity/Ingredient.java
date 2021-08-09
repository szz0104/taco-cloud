package org.htsg.tacocloud.entity;

import lombok.*;

/**
 * @author Microsoft
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        /**
         * 包裹
         */
        WRAP,
        /**
         * 蛋白质
         */
        PROTEIN,
        /**
         * 蔬菜
         */
        VEGGIES,
        /**
         * 奶酪
         */
        CHEESE,
        /**
         * 酱汁
         */
        SAUCE
    }
}
