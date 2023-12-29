package org.example;

/**
 * A door representation, holding the door's id.
 *
 * @author jens.ostlund
 */
public class Door
{
    private final int id;

    public Door(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }
}
