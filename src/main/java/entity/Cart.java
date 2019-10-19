package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class Cart {
    private UserBean user;
    private Set<BookBean> books = new HashSet<>();

    public void add(BookBean item){
        books.add(item);
    }

    public void remove(BookBean item){
        books.remove(item);
    }

    public BigDecimal getPrice(){
        BigDecimal sum = BigDecimal.valueOf(0L);
        for(BookBean item: books){
            sum = sum.add(item.getPrice());
        }
        return sum;
    }

    public int getQuantity(){
        return books.size();
    }
}
