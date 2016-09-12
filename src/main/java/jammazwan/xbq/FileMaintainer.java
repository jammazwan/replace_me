package jammazwan.xbq;

import org.springframework.stereotype.Component;

@Component
public class FileMaintainer {
	private boolean hasNotes;
	private boolean hasPom;
	private boolean hasReadme;
	private boolean hasExtra;
	private boolean hasJenkins;

	void takeInput(String fileName) {
		switch (fileName) {
		case "README.md":
			hasReadme = true;
			break;
		case "NOTES.md":
			hasNotes = true;
			break;
		case "EXTRA.md":
			hasExtra = true;
			break;
		case "Jenkinsfile":
			hasJenkins = true;
			break;
		case "pom.xml":
			hasPom = true;
			break;
		default:
			break;
		}
	}

	public boolean hasNotes() {
		return hasNotes;
	}

	public boolean hasPom() {
		return hasPom;
	}

	public boolean hasReadme() {
		return hasReadme;
	}

	public boolean hasExtra() {
		return hasExtra;
	}

	public boolean hasJenkins() {
		return hasJenkins;
	}

}
