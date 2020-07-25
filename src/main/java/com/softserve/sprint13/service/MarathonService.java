package com.softserve.sprint13.service;

import com.softserve.sprint13.entity.Marathon;
import com.softserve.sprint13.entity.Task;
import com.softserve.sprint13.entity.User;

import java.util.List;

public interface MarathonService {

     List<Marathon> getAll();

     Marathon getMarathonById(Long id);

     Marathon createOrUpdate(Marathon marathon);

     void deleteMarathonById(Long id);
}
