package ClientAndServer;

/**
* ClientAndServer/StatusHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Camera.idl
* Thursday, 13 April 2017 15:23:09 o'clock BST
*/

public final class StatusHolder implements org.omg.CORBA.portable.Streamable
{
  public ClientAndServer.Status value = null;

  public StatusHolder ()
  {
  }

  public StatusHolder (ClientAndServer.Status initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ClientAndServer.StatusHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ClientAndServer.StatusHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ClientAndServer.StatusHelper.type ();
  }

}
