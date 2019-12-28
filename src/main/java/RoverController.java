public class RoverController {

    private Rover rover;

    public RoverController(Rover rover) {

        this.rover = rover;
    }

    public String excute(String mission) {

       // String mission = "10,10,5,5,E,M,L,M";
        String[] command = mission.split(",");
        Area area = new Area(Integer.parseInt(command[0]),Integer.parseInt(command[1]));

        rover.land(area,Integer.parseInt(command[2]),Integer.parseInt(command[3]),command[4]);
        for (int i = 5; i <command.length ; i++) {
            if (command[i] .equals("L") ){
                rover.turnleft();
            } else if (command[i].equals("R") ) {
                rover.turnright();
            } else {
                rover.move();
            }
        }
        return rover.getPosition();
    }
}
