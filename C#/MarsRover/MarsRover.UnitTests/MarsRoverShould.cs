using FluentAssertions;
using NUnit.Framework;

namespace MarsRover.UnitTests
{
    public class MarsRoverShould
    {
        private const string GridDimensions = "5 5";

        [TestCase(GridDimensions + "\n1 2 N\n", "1 2 N")]
        [TestCase(GridDimensions + "\n1 2 N\nL", "1 2 W")]
        [TestCase(GridDimensions + "\n1 2 N\nR", "1 2 E")]
        [TestCase(GridDimensions + "\n1 2 N\nLL", "1 2 S")]
        [TestCase(GridDimensions + "\n1 2 N\nRR", "1 2 S")]
        [TestCase(GridDimensions + "\n1 2 E\nL", "1 2 N")]
        [TestCase(GridDimensions + "\n1 2 E\nR", "1 2 S")]
        [TestCase(GridDimensions + "\n1 2 E\nLL", "1 2 W")]
        [TestCase(GridDimensions + "\n1 2 E\nRR", "1 2 W")]
        [TestCase(GridDimensions + "\n1 2 S\nL", "1 2 E")]
        [TestCase(GridDimensions + "\n1 2 S\nR", "1 2 W")]
        [TestCase(GridDimensions + "\n1 2 S\nLL", "1 2 N")]
        [TestCase(GridDimensions + "\n1 2 S\nRR", "1 2 N")]
        [TestCase(GridDimensions + "\n1 2 W\nL", "1 2 S")]
        [TestCase(GridDimensions + "\n1 2 W\nR", "1 2 N")]
        [TestCase(GridDimensions + "\n1 2 W\nLL", "1 2 E")]
        [TestCase(GridDimensions + "\n1 2 W\nRR", "1 2 E")]
        public void RotateToOrientationSpecifiedByInput(string roverInput, string expectedOutput)
        {
            var marsRover = new MarsRover();

            var result = MarsRover.Move(roverInput);

            result.Should().Be(expectedOutput);
        }

        [TestCase(GridDimensions + "\n1 2 N\nM", "1 3 N")]
        [TestCase(GridDimensions + "\n1 2 E\nM", "2 2 E")]
        [TestCase(GridDimensions + "\n1 2 S\nM", "1 1 S")]
        [TestCase(GridDimensions + "\n2 2 W\nM", "1 2 W")]
        public void MoveForwardOnceWhenSpecifiedByInput(string marsRoverInput, string expectedResult)
        {
            var marsRover = new MarsRover();

            var result = MarsRover.Move(marsRoverInput);

            result.Should().Be(expectedResult);
        }

        [TestCase("1 1\n1 1 N\nM", "1 1 N")]
        [TestCase("1 1\n1 1 E\nM", "1 1 E")]
        [TestCase("1 1\n1 1 S\nM", "1 1 S")]
        [TestCase("1 1\n1 1 W\nM", "1 1 W")]
        public void NotMoveBeyondGridBoundary(string marsRoverInput, string expectedResult)
        {
            var marsRover = new MarsRover();
            var result = MarsRover.Move(marsRoverInput);
            result.Should().Be(expectedResult);
        }
    }
}