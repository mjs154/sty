package com.mjs.study.entity.pojo;

import java.util.ArrayList;
import java.util.List;

public class PaymentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaymentInfoExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAcceptidIsNull() {
            addCriterion("AcceptId is null");
            return (Criteria) this;
        }

        public Criteria andAcceptidIsNotNull() {
            addCriterion("AcceptId is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptidEqualTo(String value) {
            addCriterion("AcceptId =", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotEqualTo(String value) {
            addCriterion("AcceptId <>", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThan(String value) {
            addCriterion("AcceptId >", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThanOrEqualTo(String value) {
            addCriterion("AcceptId >=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThan(String value) {
            addCriterion("AcceptId <", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThanOrEqualTo(String value) {
            addCriterion("AcceptId <=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLike(String value) {
            addCriterion("AcceptId like", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotLike(String value) {
            addCriterion("AcceptId not like", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidIn(List<String> values) {
            addCriterion("AcceptId in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotIn(List<String> values) {
            addCriterion("AcceptId not in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidBetween(String value1, String value2) {
            addCriterion("AcceptId between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotBetween(String value1, String value2) {
            addCriterion("AcceptId not between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andTransnoIsNull() {
            addCriterion("TransNo is null");
            return (Criteria) this;
        }

        public Criteria andTransnoIsNotNull() {
            addCriterion("TransNo is not null");
            return (Criteria) this;
        }

        public Criteria andTransnoEqualTo(String value) {
            addCriterion("TransNo =", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoNotEqualTo(String value) {
            addCriterion("TransNo <>", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoGreaterThan(String value) {
            addCriterion("TransNo >", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoGreaterThanOrEqualTo(String value) {
            addCriterion("TransNo >=", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoLessThan(String value) {
            addCriterion("TransNo <", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoLessThanOrEqualTo(String value) {
            addCriterion("TransNo <=", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoLike(String value) {
            addCriterion("TransNo like", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoNotLike(String value) {
            addCriterion("TransNo not like", value, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoIn(List<String> values) {
            addCriterion("TransNo in", values, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoNotIn(List<String> values) {
            addCriterion("TransNo not in", values, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoBetween(String value1, String value2) {
            addCriterion("TransNo between", value1, value2, "transno");
            return (Criteria) this;
        }

        public Criteria andTransnoNotBetween(String value1, String value2) {
            addCriterion("TransNo not between", value1, value2, "transno");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("CreatTime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("CreatTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(String value) {
            addCriterion("CreatTime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(String value) {
            addCriterion("CreatTime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(String value) {
            addCriterion("CreatTime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(String value) {
            addCriterion("CreatTime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(String value) {
            addCriterion("CreatTime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(String value) {
            addCriterion("CreatTime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLike(String value) {
            addCriterion("CreatTime like", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotLike(String value) {
            addCriterion("CreatTime not like", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<String> values) {
            addCriterion("CreatTime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<String> values) {
            addCriterion("CreatTime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(String value1, String value2) {
            addCriterion("CreatTime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(String value1, String value2) {
            addCriterion("CreatTime not between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("Extend is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("Extend is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("Extend =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("Extend <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("Extend >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("Extend >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("Extend <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("Extend <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("Extend like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("Extend not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("Extend in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("Extend not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("Extend between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("Extend not between", value1, value2, "extend");
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