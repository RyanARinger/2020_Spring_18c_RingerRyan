/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classwork_022520;

/**
 *
 * @author Ryan Ringer
 */
public class DirtBlock extends Block{
    
    
    public DirtBlock(){
        this.setTextureName("D");
    }
    
//    public void render(){
//        String output = "";
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                output += this.getTextureName();
//            }
//            output += '\n';
//        }
//        
//        System.out.println(output);
//    }

    @Override
    public void render() {
    }

    @Override
    public void setTextureName(String n) {
    }

    @Override
    public String getTextureName() {
        
        return this.textureName;
    }

    
}
