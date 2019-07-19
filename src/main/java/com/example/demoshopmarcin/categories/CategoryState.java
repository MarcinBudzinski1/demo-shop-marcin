package com.example.demoshopmarcin.categories;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryState {
    boolean opened;
    boolean disabled;
    boolean selected;

}
