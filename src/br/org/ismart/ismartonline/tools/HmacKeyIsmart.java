/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.ismart.ismartonline.tools;

import java.util.HashSet;
import java.util.Set;
import net.adamcin.httpsig.api.Algorithm;
import net.adamcin.httpsig.hmac.HmacKey;

/**
 *
 * @author thiago
 */
public class HmacKeyIsmart extends HmacKey {
    
    public HmacKeyIsmart(String keyId, String secret) {
        super(keyId, secret);
    }
    
    @Override
    public Set<Algorithm> getAlgorithms() {
         Set<Algorithm> algorithms = new HashSet<Algorithm>();
 
         algorithms.add(Algorithm.HMAC_SHA256);
 
         return algorithms;
     }
    
}
