package com.solponge.domain.cart.impl;

import com.solponge.domain.cart.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CartServiceImpl implements CartService {
    private final CartItemDAO cartItemDAO;
    private final CartDAO cartDAO;

    public CartServiceImpl(CartItemDAO cartItemDAO, CartDAO cartDAO) {
        this.cartItemDAO = cartItemDAO;
        this.cartDAO = cartDAO;
    }


    @Override
    public int addItem(CartItemVo cartItem) {
        String cart_item_num = cartItemDAO.cartItemInsert(cartItem);
        return Integer.parseInt(cart_item_num);
    }

    @Override
    public void updateItem(int cart_item_num, CartItemVo cartItem) {
        cartItemDAO.cartItemUpdate(cart_item_num,cartItem);
    }

    @Override
    public void deleteItem(CartItemVo cartItem) {
        cartItemDAO.cartItemDelete(cartItem.getCART_ITEM_NUM());
    }

    @Override
    public CartItemVo findItem(int cart_item_num) {
        return cartItemDAO.cartItemFindByNum(cart_item_num);
    }

    @Override
    public int createCart(CartVo cartVo) {
        cartDAO.cartInsert(cartVo);
        return cartVo.getCART_NUM();
    }

    @Override
    public List<CartListVo> cartList(int member_num) {
        return cartDAO.showMemberCart(member_num);
    }
}