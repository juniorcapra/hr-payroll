package com.devsuperior.hrpayroll.services;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

//    @Value("${hr-worker.host}")
//    private String workerHost;


//    @Autowired
//    private RestTemplate restTemplate;

    public Payment getPayment(long workerId, int days) {

//        Map<String,String> uriVariable = new HashMap<>();
//        uriVariable.put("id",""+workerId);
//        Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}", Worker.class, uriVariable);

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}

