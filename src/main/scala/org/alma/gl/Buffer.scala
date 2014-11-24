package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
abstract class Buffer {
    protected var content: String = null
        
    def Buffer(String text){
        this.content = text
    }
        
    def getContent:String={
        content
    }
    
}