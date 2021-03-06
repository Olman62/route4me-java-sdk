package com.route4me.sdk.examples;

import com.route4me.sdk.Route4Me;
import com.route4me.sdk.model.Base;
import com.route4me.sdk.model.DataObject;
import com.route4me.sdk.model.Response;
import com.route4me.sdk.model.Route;
import com.route4me.sdk.model.enums.Constants;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juan
 */
public class ReOptimization {
    
    public static void main(String[] args) {
        String apiKey = "11111111111111111111111111111111";
        Route4Me route4me = new Route4Me(apiKey);
        Map<String, String> params = new HashMap<>();
        params.put("optimization_problem_id", "5ACDD6065C45A34768EA97FEBB14D637");
        params.put("reoptimize", "1");
        params.put("remote_ip", "192168001001");
        Route route = route4me.getRoute();
        route.setParams(params);
        Response response = route4me.reOptimization();
        DataObject responseObject = Base.GSONDeserializer.fromJson(response.getResponseBody(), DataObject.class);
        String jsonResponse = Base.GSONSerializer.toJson(responseObject);
        System.out.println(jsonResponse);
        System.out.println("Response Code:" + response.getResponseCode());        
        System.out.println("Optimization Problem ID:" + responseObject.getOptimization_problem_id());
        System.out.println("State:" + Constants.OptimizationState.get(responseObject.getState().intValue()));
        
    }    
    
    
}
