package com.example.publish;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SenderController {

	@Autowired
    private PublishApplication.PubsubOutboundGateway messagingGateway;
	
	 @RequestMapping(value="/postMessage" , method=RequestMethod.POST)
	    public String publishMessage(@RequestBody SenderMessage obj) {
		 messagingGateway.sendToPubsub(obj.getMessage().toString());
		 return "message delivered successfully";
	           
	    }
	    

}
