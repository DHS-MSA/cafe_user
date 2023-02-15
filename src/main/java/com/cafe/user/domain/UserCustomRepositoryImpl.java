package com.cafe.user.domain;

import com.cafe.user.dto.UserInfoDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import static com.cafe.user.domain.QUser.user;


@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    public UserCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }


    @Override
    public UserInfoDTO getUserInfo() throws Exception {

        return  jpaQueryFactory.
                select(Projections.fields(
                        UserInfoDTO.class,
                        user.userId,
                        user.address,
                        user.name,
                        user.createdAt,
                        user.phoneNumber))
                .from(user).where(user.userId.eq("test")).fetchOne();
    }
}
