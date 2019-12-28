import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;


public class MarsRoverTest {
 @Test
 public void should_land_the_rover_on_are() {
     Area area = new Area(10, 10);
     Rover rover = new Rover();
     rover.land(area, 5, 5, "E");
     String position = rover.getPosition();
     assertThat(position).isEqualTo("55E");
 }

 @Test
 public void should_move_forward(){
     Area area = new Area(10,10);
     Rover rover = new Rover();
     rover.land(area,5,5,"W");
     rover.move();
     String position = rover.getPosition();
     assertThat(position).isEqualTo("45W");
 }
    @Test
    public void should_turn_left(){
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,"S");
        rover.turnleft();
        assertThat(rover.getPosition()).isEqualTo("55E");
        rover.turnleft();
        assertThat(rover.getPosition()).isEqualTo("55N");
        rover.turnleft();
        assertThat(rover.getPosition()).isEqualTo("55W");
        rover.turnleft();
        assertThat(rover.getPosition()).isEqualTo("55S");
    }

    @Test
    public void should_turn_right(){
        Area area = new Area(10,10);
        Rover rover = new Rover();
        rover.land(area,5,5,"S");
        rover.turnright();
        assertThat(rover.getPosition()).isEqualTo("55W");
        rover.turnright();
        assertThat(rover.getPosition()).isEqualTo("55N");
        rover.turnright();
        assertThat(rover.getPosition()).isEqualTo("55E");
        rover.turnright();
        assertThat(rover.getPosition()).isEqualTo("55S");
    }

    @Test
    public void should_execute_bentch_command(){
        Rover rover = new Rover();
        RoverController roverController = new RoverController(rover);
        String mission = "10,10,5,5,E,M,L,M,R";
        String position = roverController.excute(mission);
        assertThat(position).isEqualTo("66E");
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public void should_warning_when_land_out_of_area(){
       expectedException.expect(IllegalArgumentException.class);
       expectedException.expectMessage("x=20 is out of area width 10");
       Area area = new Area(10,10);
       Rover rover= new Rover();
       rover.land(area,20,30,"S");
    }




}
