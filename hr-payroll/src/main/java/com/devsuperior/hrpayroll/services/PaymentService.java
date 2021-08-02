package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){

        //Para acessar o objeto worker dentro do response entity e necessário usar o getBody() - corpo da resposta
        Worker worker = workerFeignClient.findById(workerId).getBody();
        //Requisição para uma api externa, preenchimento dinamico
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
