package ClientAndServer;

/**
* ClientAndServer/AlarmDataHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from RegOffice.idl
* Thursday, 13 April 2017 13:17:23 o'clock BST
*/

public final class AlarmDataHolder implements org.omg.CORBA.portable.Streamable
{
  public ClientAndServer.AlarmData value = null;

  public AlarmDataHolder ()
  {
  }

  public AlarmDataHolder (ClientAndServer.AlarmData initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ClientAndServer.AlarmDataHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ClientAndServer.AlarmDataHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ClientAndServer.AlarmDataHelper.type ();
  }

}
