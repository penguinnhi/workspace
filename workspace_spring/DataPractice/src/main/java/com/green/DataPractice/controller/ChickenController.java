package com.green.DataPractice.controller;

import com.green.DataPractice.vo.DeliveryVO;
import com.green.DataPractice.vo.OrderVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChickenController {

    //주문 정보 페이지로 이동
    @GetMapping("/order")
    public String order(OrderVO orderVO){
        System.out.println(orderVO);
        return "order";
    }

    //배달 정보 페이지로 이동
    @PostMapping("/delivery")
    public String delivery(OrderVO orderVO,DeliveryVO deliveryVO){
        System.out.println(orderVO);
        System.out.println(deliveryVO);
        return "delivery";
    }

    //주문 정보 확인 페이지로 이동
    @PostMapping("/order_info")
    public String orderInfo(OrderVO orderVO, DeliveryVO deliveryVO, Model model){
        System.out.println(orderVO);
        System.out.println(deliveryVO);

        int cnt=0;
        for (String e:orderVO.getAdd()){
            cnt++;
        }

        int sum=(10000*orderVO.getNum())+(1000*cnt);
        model.addAttribute("sum",sum); //************************

        return "order_info";
    }


}
