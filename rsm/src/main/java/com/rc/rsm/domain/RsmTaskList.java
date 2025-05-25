package com.rc.rsm.domain;

import com.rc.rsm.domain.po.RsmTask;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RsmTaskList {
    List<RsmTask> rsmTaskList = new ArrayList<>();
}
