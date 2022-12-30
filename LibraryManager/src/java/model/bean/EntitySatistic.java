package model.bean;

public class EntitySatistic {
    private Object entity;
    private int quantity;

    public EntitySatistic(Object entity, int quantity) {
        this.entity = entity;
        this.quantity = quantity;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
