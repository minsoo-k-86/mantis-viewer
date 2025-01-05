package com.messier219.mantis_viewer.bug;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Bug DB Mapper
 * @author messier219
 */
@Mapper
public interface BugMapper {

    List<Bug> findAll();
}
