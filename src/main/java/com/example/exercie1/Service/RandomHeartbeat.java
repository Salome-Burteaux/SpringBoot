package com.example.exercie1.Service;

import com.example.exercie1.HeartbeatSensor;
import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor {
    @Override
    public int get() {
        return 0;
    }
}
