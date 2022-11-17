package view;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import config.*;
import model.actions.DeleteNoteAction;
import model.actions.EditNoteAction;
import model.filehandling.ProjectsHandling;


public class ProjectWindow {
    JFrame mainFrame;
    JPanel panel;
    JPanel notePanel;
    JLabel title;
    int numNotes;
    JTextArea descriptionBox;
    JLabel priorityLabel;
    JButton editButton;
    JButton deleteButton;
    GridBagConstraints constraints;
    ArrayList<String[]> notesContents;
    String[] noteData;
    ArrayList<JPanel> notePanelsArray;
    String projectPath;
    String projectName;

    public ProjectWindow() {
        projectPath = FilePaths.CURRENTOPENFILE;
        numNotes = ProjectsHandling.getNumNotesFromProject(projectPath);
        notesContents = ProjectsHandling.getNotesContentsFromProject(projectPath);
        notePanelsArray = new ArrayList<JPanel>();
        projectName = ProjectsHandling.getProjectName(projectPath);

        try {
            mainFrame = Window.getJFrame();
            panel = new JPanel();

            createNotePanels();

            addNotePanelsToFrame();

            mainFrame.add(panel);
            Window.revalidateFrame();
        } catch (IndexOutOfBoundsException e) {
            // e.printStackTrace();
            System.out.println("No Notes to show, empty project");
            mainFrame = Window.getJFrame();
            panel = new JPanel(new GridBagLayout());
            title = new JLabel("No notes to show, empty project");
            panel.add(title);
            mainFrame.add(panel);
            Window.revalidateFrame();
        }
    }

    private void addNotePanelsToFrame() throws IndexOutOfBoundsException {
        int x = 0;
        int i;
        for (i = 0; i < notePanelsArray.size() - 1; i++) {
            notePanel = notePanelsArray.get(i);
            if (i % 4 == 0) {
                x++;
            }
            GridPositioning.positionComponent(panel, notePanel, i, x, GridBagConstraints.CENTER, 0.0, 0.0, 1, 1);
        }
        notePanel = notePanelsArray.get(i);
        GridPositioning.positionComponent(panel, notePanel, i, x, GridBagConstraints.CENTER, 0.0, 0.0, 1, 1);
    }

    private void createNotePanels() {
        for (int i=0; i < numNotes; i++) {
            noteData = notesContents.get(i);

            notePanel = new JPanel(new GridBagLayout());
            notePanel.setBorder(BorderFactory.createLineBorder(Color.black));

            editButton = new JButton("Edit Note");
            editButton.setAction(new EditNoteAction(notePanel));

            deleteButton = new JButton("Delete Note");
            deleteButton.setAction(new DeleteNoteAction(notePanel));

            title = new JLabel(noteData[0]);

            descriptionBox = new JTextArea(noteData[2]);
            descriptionBox.setEditable(false);

            priorityLabel = new JLabel(noteData[1]);

            positionNoteComponents();
            notePanelsArray.add(notePanel);
        }
    }

    private void positionNoteComponents() {
        GridPositioning.positionComponent(notePanel, title, 0, 0, GridBagConstraints.FIRST_LINE_START, 0.5, 0.8, 1, 1);
        GridPositioning.positionWithPadding(notePanel, editButton, 1, 0, GridBagConstraints.CENTER, 0.0, 0.0, 1, 1, 5, 5);
        GridPositioning.positionComponent(notePanel, priorityLabel, 3, 0, GridBagConstraints.FIRST_LINE_END, 0.0, 0.0, 1, 1);
        GridPositioning.positionComponent(notePanel, descriptionBox, 0, 1, GridBagConstraints.PAGE_END, 0.0, 0.1, 3, 1);
        GridPositioning.positionComponent(notePanel, deleteButton, 2, 0, GridBagConstraints.CENTER, 0.0, 0.0, 1, 1);
}
}
