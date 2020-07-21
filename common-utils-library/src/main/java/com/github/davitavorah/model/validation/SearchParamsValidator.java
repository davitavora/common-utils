package com.github.davitavorah.model.validation;

import com.github.davitavorah.model.SearchParams;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SearchParamsValidator implements ConstraintValidator<ValidSearchParams, SearchParams> {
 
   private ValidSearchParams validSearchParams;
 
   public void initialize(ValidSearchParams validSearchParams) {
      this.validSearchParams = validSearchParams;
   }

   public boolean isValid(SearchParams searchParams, ConstraintValidatorContext context) {
      searchParams.setOrder(Option.of(searchParams.getOrder()).getOrElse(validSearchParams.order()));
      var finalOrder = searchParams.getOrder().startsWith("-") ? searchParams.getOrder().substring(1) : searchParams.getOrder();
      return Stream.of(validSearchParams.allowedOrders()).map(String::toLowerCase).contains(finalOrder.toLowerCase());
   }

}
