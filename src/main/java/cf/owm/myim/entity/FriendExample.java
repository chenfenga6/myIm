package cf.owm.myim.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FriendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FriendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNull() {
            addCriterion("friend_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNotNull() {
            addCriterion("friend_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendIdEqualTo(String value) {
            addCriterion("friend_id =", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotEqualTo(String value) {
            addCriterion("friend_id <>", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThan(String value) {
            addCriterion("friend_id >", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThanOrEqualTo(String value) {
            addCriterion("friend_id >=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThan(String value) {
            addCriterion("friend_id <", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThanOrEqualTo(String value) {
            addCriterion("friend_id <=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLike(String value) {
            addCriterion("friend_id like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotLike(String value) {
            addCriterion("friend_id not like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIn(List<String> values) {
            addCriterion("friend_id in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotIn(List<String> values) {
            addCriterion("friend_id not in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdBetween(String value1, String value2) {
            addCriterion("friend_id between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotBetween(String value1, String value2) {
            addCriterion("friend_id not between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNull() {
            addCriterion("friend_name is null");
            return (Criteria) this;
        }

        public Criteria andFriendNameIsNotNull() {
            addCriterion("friend_name is not null");
            return (Criteria) this;
        }

        public Criteria andFriendNameEqualTo(String value) {
            addCriterion("friend_name =", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotEqualTo(String value) {
            addCriterion("friend_name <>", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThan(String value) {
            addCriterion("friend_name >", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameGreaterThanOrEqualTo(String value) {
            addCriterion("friend_name >=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThan(String value) {
            addCriterion("friend_name <", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLessThanOrEqualTo(String value) {
            addCriterion("friend_name <=", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameLike(String value) {
            addCriterion("friend_name like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotLike(String value) {
            addCriterion("friend_name not like", value, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameIn(List<String> values) {
            addCriterion("friend_name in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotIn(List<String> values) {
            addCriterion("friend_name not in", values, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameBetween(String value1, String value2) {
            addCriterion("friend_name between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendNameNotBetween(String value1, String value2) {
            addCriterion("friend_name not between", value1, value2, "friendName");
            return (Criteria) this;
        }

        public Criteria andFriendTypeIsNull() {
            addCriterion("friend_type is null");
            return (Criteria) this;
        }

        public Criteria andFriendTypeIsNotNull() {
            addCriterion("friend_type is not null");
            return (Criteria) this;
        }

        public Criteria andFriendTypeEqualTo(String value) {
            addCriterion("friend_type =", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotEqualTo(String value) {
            addCriterion("friend_type <>", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeGreaterThan(String value) {
            addCriterion("friend_type >", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeGreaterThanOrEqualTo(String value) {
            addCriterion("friend_type >=", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeLessThan(String value) {
            addCriterion("friend_type <", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeLessThanOrEqualTo(String value) {
            addCriterion("friend_type <=", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeLike(String value) {
            addCriterion("friend_type like", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotLike(String value) {
            addCriterion("friend_type not like", value, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeIn(List<String> values) {
            addCriterion("friend_type in", values, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotIn(List<String> values) {
            addCriterion("friend_type not in", values, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeBetween(String value1, String value2) {
            addCriterion("friend_type between", value1, value2, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendTypeNotBetween(String value1, String value2) {
            addCriterion("friend_type not between", value1, value2, "friendType");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdIsNull() {
            addCriterion("friend_group_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdIsNotNull() {
            addCriterion("friend_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdEqualTo(String value) {
            addCriterion("friend_group_id =", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdNotEqualTo(String value) {
            addCriterion("friend_group_id <>", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdGreaterThan(String value) {
            addCriterion("friend_group_id >", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("friend_group_id >=", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdLessThan(String value) {
            addCriterion("friend_group_id <", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdLessThanOrEqualTo(String value) {
            addCriterion("friend_group_id <=", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdLike(String value) {
            addCriterion("friend_group_id like", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdNotLike(String value) {
            addCriterion("friend_group_id not like", value, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdIn(List<String> values) {
            addCriterion("friend_group_id in", values, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdNotIn(List<String> values) {
            addCriterion("friend_group_id not in", values, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdBetween(String value1, String value2) {
            addCriterion("friend_group_id between", value1, value2, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andFriendGroupIdNotBetween(String value1, String value2) {
            addCriterion("friend_group_id not between", value1, value2, "friendGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andFriendStatusIsNull() {
            addCriterion("friend_status is null");
            return (Criteria) this;
        }

        public Criteria andFriendStatusIsNotNull() {
            addCriterion("friend_status is not null");
            return (Criteria) this;
        }

        public Criteria andFriendStatusEqualTo(Integer value) {
            addCriterion("friend_status =", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusNotEqualTo(Integer value) {
            addCriterion("friend_status <>", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusGreaterThan(Integer value) {
            addCriterion("friend_status >", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("friend_status >=", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusLessThan(Integer value) {
            addCriterion("friend_status <", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("friend_status <=", value, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusIn(List<Integer> values) {
            addCriterion("friend_status in", values, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusNotIn(List<Integer> values) {
            addCriterion("friend_status not in", values, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusBetween(Integer value1, Integer value2) {
            addCriterion("friend_status between", value1, value2, "friendStatus");
            return (Criteria) this;
        }

        public Criteria andFriendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("friend_status not between", value1, value2, "friendStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}