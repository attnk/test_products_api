package com.br.productapi.product.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/", produces=APPLICATION_JSON_UTF8_VALUE)
public class ProductController {

}
