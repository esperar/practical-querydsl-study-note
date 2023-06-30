package esperer.querydsl.repository;

import esperer.querydsl.dto.MemberDto;
import esperer.querydsl.dto.MemberSearchCondition;
import esperer.querydsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSearchCondition condition);
}
