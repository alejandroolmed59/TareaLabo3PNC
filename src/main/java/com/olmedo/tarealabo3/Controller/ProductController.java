package com.olmedo.tarealabo3.Controller;

import com.olmedo.tarealabo3.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private List<Product> productos =new ArrayList<Product>(){
        {
            add(new Product(0, "Papel higienico", "20"));
            add(new Product(1, "Churros diana", "12"));
            add(new Product(2, "Chicles", "15"));
            add(new Product(3, "Cereal", "31"));
            add(new Product(4, "Pasta dental", "53"));
            add(new Product(5, "Coca cola", "9001"));
        }
    };

    @GetMapping("/comprarProducto")
    public ModelAndView compraProducto(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("productos");
        mav.addObject("product", new Product());
        mav.addObject("productos", this.productos);
        return mav;
    }
    @PostMapping("/validar")
    public ModelAndView proc(Product product){
        ModelAndView mav = new ModelAndView();

        Product productBD = productos.get(product.getId());
       // System.out.println("BD "+ productBD.getNombre()+productBD.getCantidad());
        if(Integer.parseInt(productBD.getCantidad())<Integer.parseInt(product.getCantidad())){
            mav.setViewName("Error");
        }else{
            mav.setViewName("Compra");
        }
        mav.addObject("product", productBD);
        return mav;
    }

}
